package me.dioSantander.santanderAPIRest.Domain.Repository;

import me.dioSantander.santanderAPIRest.Domain.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author João Victor Ricci
 *
 *
 */
//Utilizando o JpaRepository ou CrudRepository(querys simples),
//Devemos na primeira tipagem declarar a entidade, neste caso USER,
//Na segunda, declaramo o TIPO DO ID, neste caso Long.
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByAccountNumber(String accountNumber);
}
