package br.com.connect.source;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class SourceController {
		
	
	@GetMapping("/source")
    public String source() {
        return "https://github.com/paiva33/connect.git";
    }
	
	
	
}
