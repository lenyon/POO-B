package br.fatec.HelpDesk.contexts.autenticacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoController {

    @Autowired
    AutenticacaoService autenticacaoService;

    @GetMapping("{email}/{senha}")
    public @ResponseBody ResponseEntity<AutenticacaoDTO> autenticar(@PathVariable String email,
                                                    @PathVariable String senha) {

        AutenticacaoDTO autenticacaoDTO = AutenticacaoDTO.valueof(autenticacaoService.autenticar(email, senha));
        if (autenticacaoDTO != null) {
            return ResponseEntity.ok().body(autenticacaoDTO);
        }
        return ResponseEntity.badRequest().build();
    }

}
