package io.github.womensworldcup2023.controller

import io.github.womensworldcup2023.controller.dto.TeamDto
import io.github.womensworldcup2023.service.TeamService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/teams")
@Tag(name = "Teams Controller", description = "RESTful API for managing teams.")
class TeamController(private val teamService: TeamService) {

    @GetMapping
    @Operation(summary = "Get all teams", description = "Retrieve a list of all registered teams")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Operation successful")
    ])
    fun findAll(): ResponseEntity<List<TeamDto>>{
        val teams = teamService.findAll()
        val teamDto = teams.map { TeamDto(it) }
        return ResponseEntity.ok(teamDto)
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a team by ID", description = "Retrieve a specific team based on its ID (abbreviation).")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Operation successful"),
        ApiResponse(responseCode = "404", description = "Team not found")
    ])
    fun findById(@PathVariable id: String): ResponseEntity<TeamDto> {
        val team = teamService.findById(id)
        return ResponseEntity.ok(TeamDto(team))
    }

    @PostMapping
    @Operation(summary = "Create a new team", description = "Create a new team and return the created team's data")
    @ApiResponses(value = [
        ApiResponse(responseCode = "201", description = "Team created successfully"),
        ApiResponse(responseCode = "422", description = "Invalid team data provided")
    ])
    fun create(@RequestBody teamDto: TeamDto): ResponseEntity<TeamDto> {
        val team = teamService.create(teamDto.toModel())
        val location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(team.id)
            .toUri()
        return ResponseEntity.created(location).body(TeamDto(team))
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a team", description = "Update the data of an existing team based on its ID (abbreviation).")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Team updated successfully"),
        ApiResponse(responseCode = "404", description = "Team not found"),
        ApiResponse(responseCode = "422", description = "Invalid team data provided")
    ])
    fun update(@PathVariable id: String, @RequestBody teamDto: TeamDto): ResponseEntity<TeamDto> {
        val team = teamService.update(id, teamDto.toModel())
        return ResponseEntity.ok(TeamDto(team))
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a team", description = "Delete an existing team based on its ID (abbreviation).")
    @ApiResponses(value = [
        ApiResponse(responseCode = "204", description = "Team deleted successfully"),
        ApiResponse(responseCode = "404", description = "Team not found")
    ])
    fun delete(@PathVariable id: String): ResponseEntity<Void> {
        teamService.delete(id)
        return ResponseEntity.noContent().build()
    }
}