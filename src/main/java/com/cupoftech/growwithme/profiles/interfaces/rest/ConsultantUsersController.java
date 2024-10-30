package com.cupoftech.growwithme.profiles.interfaces.rest;

import com.cupoftech.growwithme.profiles.domain.model.queries.consultant.GetConsultantUserByIdQuery;
import com.cupoftech.growwithme.profiles.domain.services.consultant.ConsultantUserCommandService;
import com.cupoftech.growwithme.profiles.domain.services.consultant.ConsultantUserQueryService;
import com.cupoftech.growwithme.profiles.interfaces.rest.resources.consultant.ConsultantUserResource;
import com.cupoftech.growwithme.profiles.interfaces.rest.resources.consultant.CreateConsultantUserResource;
import com.cupoftech.growwithme.profiles.interfaces.rest.transform.consultant.ConsultantUserResourceFromEntityAssembler;
import com.cupoftech.growwithme.profiles.interfaces.rest.transform.consultant.CreateConsultantUserCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/consultant-users", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "ConsultantUsers", description = "Consultant Users Management Endpoint")
public class ConsultantUsersController {
    private final ConsultantUserCommandService consultantUserCommandService;
    private final ConsultantUserQueryService consultantUserQueryService;

    @PostMapping
    public ResponseEntity<ConsultantUserResource> createConsultantUser(@RequestBody CreateConsultantUserResource resource) {
        var createConsultantUserCommand = CreateConsultantUserCommandFromResourceAssembler.toCommandFromResource(resource);
        var consultantUser = consultantUserCommandService.handle(createConsultantUserCommand);
        if (consultantUser.isEmpty()) { return ResponseEntity.badRequest().build(); }
        var consultantUserResource = ConsultantUserResourceFromEntityAssembler.toResourceFromEntity(consultantUser.get());
        return new ResponseEntity<>(consultantUserResource, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultantUserResource> getConsultantUserById(@PathVariable Long id) {
        var getConsultantUserByIdQuery = new GetConsultantUserByIdQuery(id);
        var consultantUser = consultantUserQueryService.handle(getConsultantUserByIdQuery);
        if (consultantUser.isEmpty()) { return ResponseEntity.notFound().build(); }
        var consultantUserResource = ConsultantUserResourceFromEntityAssembler.toResourceFromEntity(consultantUser.get());
        return ResponseEntity.ok(consultantUserResource);
    }
}
