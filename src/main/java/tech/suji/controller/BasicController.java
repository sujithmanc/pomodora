package tech.suji.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class BasicController {

	@GetMapping	
	public String sayHello() {
		return "Hello world";
	}
	
	@GetMapping("/hi")
    public Map<String, String> sayHi(HttpServletRequest request) {
        var data = new HashMap<String, String>();

        // Core message
        data.put("Message", "Hello Sujith");

        // Local IP and Port
        data.put("LocalIP", request.getLocalAddr());
        data.put("LocalPort", String.valueOf(request.getLocalPort()));

        // Client info
        data.put("RemoteIP", request.getRemoteAddr());
        data.put("RemotePort", String.valueOf(request.getRemotePort()));

        // Metadata
        data.put("Protocol", request.getProtocol());
        data.put("Method", request.getMethod());
        data.put("RequestURI", request.getRequestURI());
        data.put("ServerName", request.getServerName());
        data.put("Timestamp", LocalDateTime.now().toString());

        return data;
    }

}
