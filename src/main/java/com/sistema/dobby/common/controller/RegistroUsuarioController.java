package com.sistema.dobby.administracion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioController {
//
//    @Autowired
//    private UsuarioService usuarioService;
//
//    /* Si se usa el tag th:object en el formulario crea un objecto del tipo
//     *  UsuarioRegistroDTO para rellenar los datos del formulario en el objeto.
//     * */
//    @ModelAttribute("usuario")
//    public UsuarioDTO crearUsuarioRegistroDTO() {
//        return new UsuarioDTO();
//    }
//
//    @GetMapping
//    public String mostrarFomrularioDeRegistro() {
//        return "registro";
//    }
//
//    /* Trae el objecto 'usuario' desde el formulario para guardarlo en la base de datos */
//    @PostMapping
//    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioDTO registroDTO) {
//        try {
//            /* validar correo */
//            String correo = registroDTO.getEmail();
//            //Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@roshka.com$");
//            Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@gmail.com$");
//            Matcher matcher = pattern.matcher(correo);
//
//            if(!matcher.matches()) {
//                /* verifica que sea @roshka.com */
//                return "redirect:/registro?err001";
//            }
//
////            if( !(registroDTO.getPassword().equals(registroDTO.getClaveConfirmar()) )) {
////                //verifica que las contraseñas sean iguales
////                return "redirect:/registro?err002";
////            }
//
//            if(registroDTO.getPassword().length() < 8) {
//                //verifica que la longitud sea mayor o igual a 8
//                return "redirect:/registro?err004";
//            }
//
//            if(usuarioService.existeUsuario(correo) != null) {
//                //verifica que el correo no exista en la base de datos
//                return "redirect:/registro?err003";
//            }
//
//            usuarioService.convertirDTO(registroDTO);
//            return "redirect:/registro?exito";
//        } catch (Exception e) {
//            return "redirect:/registro?error";
//        }
//    }
}
