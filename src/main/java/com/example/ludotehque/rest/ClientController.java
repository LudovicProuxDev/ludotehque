package com.example.ludotehque.rest;

import com.example.ludotehque.bll.ClientService;
import com.example.ludotehque.bo.Client;
import com.example.ludotehque.dto.ClientDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) { this.clientService = clientService; }

    // GET (Liste)
    @GetMapping
    public ResponseEntity<ApiResponse<List<Client>>> getClients() {
        List clients = clientService.trouverClients();
        return ResponseEntity.ok(new ApiResponse<>(true, "Clients retrieved successfully", clients));
    }

    // GET (Single)
    @GetMapping("/{noClient}")
    public ResponseEntity<ApiResponse<Client>> getClient(@PathVariable(name = "noClient") Integer noClient) {
        Client client = clientService.trouverClientParId(noClient);
        return ResponseEntity.ok(new ApiResponse<>(true, "Client retrieved successfully", client));
    }

    // POST
    @PostMapping
    public ResponseEntity<ApiResponse<Client>> createClient(@RequestBody ClientDTO clientDTO) {
        // Create Client
        Client client = clientService.ajouterClient(clientDTO);
        ApiResponse<Client> apiResponse = new ApiResponse<>(true, "Client created", client);
        return ResponseEntity.status(HttpStatus.CREATED).header("Location", "/api/clients/" + client.getNoClient()).body(apiResponse);
    }

    // PATCH
    @PatchMapping("/{noClient}")
    public ResponseEntity<ApiResponse<Client>> updateClient(@RequestBody ClientDTO clientDTO, @PathVariable(name = "noClient") Integer noClient) {
        // Update Client
        Client client = clientService.modifierClient(noClient, clientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).header("Location", "/api/clients/" + client.getNoClient())
                .body(new ApiResponse<>(true, "Client updated", client));
    }

    // PUT
    @PutMapping("/{noClient}")
    public ResponseEntity<ApiResponse<Client>> updateAllClient(@RequestBody ClientDTO clientDTO, @PathVariable(name = "noClient") Integer noClient) {
        // Update Client
        Client client = clientService.modifierClient(noClient, clientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).header("Location", "/api/clients/" + client.getNoClient())
                .body(new ApiResponse<>(true, "Client updated", client));
    }

    // DELETE
    @DeleteMapping("/{noClient}")
    public ResponseEntity<ApiResponse<String>> deleteClient(@PathVariable(name = "noClient") Integer noClient) {
        // Delete Client
        clientService.supprimerClient(noClient);
        return ResponseEntity.status(HttpStatus.ACCEPTED).header("Location", "/api/clients/" + noClient)
                .body(new ApiResponse<>(true, "OK", "Client deleted"));
    }

}
