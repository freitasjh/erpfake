package br.com.systec.erpfake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.systec.erpfake.client.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
