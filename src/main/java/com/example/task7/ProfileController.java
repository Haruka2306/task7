package com.example.task7;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import jakarta.validation.constraints.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

@RestController
@Validated
public class ProfileController {

    @GetMapping("/profiles")
    public List<Profile> processData(
            @NotEmpty @RequestParam List<@NotBlank String> name,
            @RequestParam List<LocalDate> dateOfBirth,
            @RequestParam List<Integer> age) {
        List<Profile> response = new ArrayList<>();
        for (int i = 0; i < name.size(); i++) {
            Profile profile = new Profile (name.get(i), dateOfBirth.get(i), age.get(i));
            response.add(profile);
        }
        return response;
    }

    @PostMapping("/profiles")
    public ResponseEntity<ProfileCreateResponse> create(@RequestBody ProfileCreateForm form){
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/profiles/{id}")
                .build()
                .toUri();
        return ResponseEntity.created(url).body(new ProfileCreateResponse("profile successfully created"));
    }

    @PatchMapping("/profiles/{id}")
    public ResponseEntity<ProfileUpdateResponse> create( @PathVariable int id, @RequestBody ProfileUpdateForm form){
        return ResponseEntity.ok(new ProfileUpdateResponse("profile successfully updated"));
    }

    @DeleteMapping("/profiles/{id}")
    public ResponseEntity<ProfileDeleteResponse> delete(@PathVariable int id){
        return ResponseEntity.ok(new ProfileDeleteResponse("profile successfully deleted"));
    }
}
