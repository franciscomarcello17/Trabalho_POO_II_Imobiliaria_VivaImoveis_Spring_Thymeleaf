/*import com.vivaimoveis.imobiliaria.model.Usuario;
import com.vivaimoveis.imobiliaria.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CadastroController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/cadastro")
    public String showCadastroForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String registerUser(@ModelAttribute Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return "cadastro";
        }
        usuarioService.cadastrar(usuario);
        return "redirect:/login";
    }
}
*/