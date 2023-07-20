package com.example.task7;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ProfileController {
    @GetMapping("/profiles")
    public List<Profile> getProfiles(){
        return List.of(new Profile("tanaka", "1989/01/01", 34),
                       new Profile("yamada", "1991/03/01", 32));
    }

    @PostMapping("/profiles")
    public ResponseEntity<ProfileCreateResponse> create(@RequestBody ProfileCreateForm form){
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/profiles")
                .build()
                .toUri();
        return ResponseEntity.created(url).body(new ProfileCreateResponse("profile successfully created"));
    }

    @PatchMapping("/profiles/{id}")
    public ResponseEntity<ProfileUpdateResponse> create( @PathVariable int id, @RequestBody ProfileUpdateForm form){
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/profiles")
                .build()
                .toUri();
        return ResponseEntity.ok(new ProfileUpdateResponse("profile successfully updated"));
    }

    @DeleteMapping("/profiles/{id}")
    public ResponseEntity<ProfileDeleteResponse> delete(@PathVariable int id){
        return ResponseEntity.ok(new ProfileDeleteResponse("profile successfully deleted"));
    }
}
