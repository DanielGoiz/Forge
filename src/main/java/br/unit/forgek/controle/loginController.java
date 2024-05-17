import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class loginController {

    @Autowired
    private JavaMailSender emailSender;

    
    private UserRepository userRepository;

    @Autowired
    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return ResponseEntity.badRequest().body("Usuário não encontrado");
        }

        String token = UUID.randomUUID().toString();

        sendTokenByEmail(user.getEmail(), token);

        return ResponseEntity.ok("Token enviado para o seu email");
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verifyToken(@RequestParam String email, @RequestParam String token) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return ResponseEntity.badRequest().body("Usuário não encontrado");
        }

       
        if (tokenIsValid(email, token)) {
            return ResponseEntity.ok("Token válido. Usuário autenticado");
        } else {
            return ResponseEntity.badRequest().body("Token inválido");
        }
    }

    private void sendTokenByEmail(String email, String token) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Token de Autenticação");
        message.setText("Seu token de autenticação é: " + token);
        emailSender.send(message);
    }

    private boolean tokenIsValid(String email, String token) {
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getToken().equals(token)) {
                return true;
            }
        }
        return false;
    }
}
