package boundary_of_law.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import boundary_of_law.persistance.PdfFileRepository;
import boundary_of_law.models.PDFFile;

@Controller
public class PDFFileController {

    @Autowired
    private PdfFileRepository pdfFileRepository;
    @RequestMapping("/pdf")
	public String displayAll(ModelMap map) throws SQLException {
		List<PDFFile> pdfFile = pdfFileRepository.getAllFiles();

		map.addAttribute("pdfFile", pdfFile);// model
		return "DisplayAllPdfFile";// view
    }
    // Create
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            PDFFile pdfFile = new PDFFile();
            pdfFile.setName(file.getOriginalFilename());
            pdfFile.setContent(file.getBytes());
            pdfFileRepository.saveFile(pdfFile);
            return ResponseEntity.status(HttpStatus.OK).body("File uploaded successfully!");
        } catch (IOException | SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file!");
        }
    }

    // Read
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) {
        try {
            PDFFile pdfFile = pdfFileRepository.getFile(id);
            if (pdfFile != null) {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(org.springframework.http.MediaType.APPLICATION_PDF);
                headers.setContentDispositionFormData("attachment", pdfFile.getName());
                return new ResponseEntity<>(pdfFile.getContent(), headers, HttpStatus.OK);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Read All
    @GetMapping("/files")
    public ResponseEntity<List<PDFFile>> getAllFiles() {
        try {
            List<PDFFile> files = pdfFileRepository.getAllFiles();
            return new ResponseEntity<>(files, HttpStatus.OK);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Update
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateFile(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        try {
            PDFFile pdfFile = new PDFFile();
            pdfFile.setId(id);
            pdfFile.setName(file.getOriginalFilename());
            pdfFile.setContent(file.getBytes());
            pdfFileRepository.updateFile(pdfFile);
            return ResponseEntity.status(HttpStatus.OK).body("File updated successfully!");
        } catch (IOException | SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update file!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // Delete
    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteFile(@PathVariable Long id) {
        try {
            pdfFileRepository.deleteFile(id);
            return ResponseEntity.status(HttpStatus.OK).body("File deleted successfully!");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete file!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
