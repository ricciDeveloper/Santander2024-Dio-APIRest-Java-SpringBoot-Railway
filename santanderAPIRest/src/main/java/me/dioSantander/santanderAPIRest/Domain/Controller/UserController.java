package me.dioSantander.santanderAPIRest.Domain.Controller;

import me.dioSantander.santanderAPIRest.Domain.Model.User;
import me.dioSantander.santanderAPIRest.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/**
 * @Author João Victor Ricci
 *
 * Controlador REST para a entidade User.
 * Utiliza @RestController para indicar que é um controlador REST.
 * Utiliza @RequestMapping para definir o caminho base para os endpoints deste controlador.
 * Exemplo: localhost:8080/users → representa os endpoints de users na API Rest.
 */
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    /**
     * Construtor do controlador que utiliza injeção de dependências.
     *
     * @param userService Serviço responsável pela lógica de negócios relacionada aos usuários.
     * Utilizamos a injeção de dependências via construtor, por boas práticas.
     * Também é possível injetá-lo sem construtor, com @Autowired, indicado para testes,
     * pois não é uma boa prática para uma aplicação de produção.
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Endpoint para buscar um usuário por ID.
     *
     * @param id Identificador do usuário a ser buscado.
     * @return ResponseEntity contendo o usuário encontrado.
     *
     * Utiliza @GetMapping para expor o endpoint como uma requisição HTTP GET.
     * @PathVariable indica que o parâmetro será extraído do caminho da URL.
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    /**
     * Endpoint para criação de um novo usuário.
     * <p>
     * Este método recebe um objeto User via requisição HTTP POST, cria o usuário
     * utilizando o serviço userService, e retorna uma resposta HTTP 201 (Created)
     * com o corpo do usuário criado. O cabeçalho Location da resposta conterá a URI
     * de acesso ao novo recurso criado.
     * </p>
     * <p>
     * Boas práticas em API recomendam devolver a localização do objeto criado ou
     * manipulado no endpoint em questão.
     * </p>
     *
     * @param userToCreate Objeto User a ser criado.
     * @return ResponseEntity contendo o usuário criado e a URI de localização.
     *
     * Utiliza @PostMapping para expor o endpoint como uma requisição HTTP POST.
     * @RequestBody indica que o parâmetro será extraído do corpo da requisição.
     */
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User userToCreate) {
        var userCreated = userService.create(userToCreate);
        // Construção da URI de localização do novo recurso
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();
        // Retorno da resposta com o status 201 e a URI no cabeçalho Location
        return ResponseEntity.created(location).body(userCreated);
    }
}
