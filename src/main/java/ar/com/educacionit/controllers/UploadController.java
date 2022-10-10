
package ar.com.educacionit.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.Part;

import org.slf4j.LoggerFactory;
import org.springframework.boot.context.logging.LoggingApplicationListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.LoggingEvent;


@Controller
@RequestMapping("/upload")
public class UploadController {

	Logger logger = (Logger) LoggerFactory.getLogger(UploadController.class);
	
	@PostMapping("/up")
		public String uploadFile(
				@RequestParam("file") MultipartFile file, 
				Model model)
				throws IOException {

			if (file == null || file.isEmpty()) {
				model.addAttribute("error", "");
				model.addAttribute("message", "Por favor seleccione un archivo");
				return "index";
			}
			
			if(!this.validar(file)) {
				model.addAttribute("error", "");
				model.addAttribute("message", "Por favor seleccione un archivo con extension .txt o .csv");
				return "index";
			}
			
			//creo el path para guardar el archivo 
			StringBuilder builder = new StringBuilder();
			builder.append("C:/desarrollo/upload_files");
			builder.append(File.separator);
			builder.append(file.getOriginalFilename());
			
			//genero el archivo
			byte[] fileBytes = file.getBytes();
			Path path = Paths.get(builder.toString());
			Files.write(path, fileBytes);
			
			logger.info("File upload Name: " + file.getOriginalFilename()+"| Size: "+file.getSize()+" bytes");
			model.addAttribute("message", "Archivo cargado correctamente en la ruta: "+builder.toString());
			return "index";
		}
		
		public boolean validar (MultipartFile file) {
			String name = file.getOriginalFilename();
			String [] arrayName = name.split("\\.");
			String ext = arrayName[arrayName.length-1]; 
			return ext.equalsIgnoreCase("csv")||ext.equalsIgnoreCase("txt");
		}
}