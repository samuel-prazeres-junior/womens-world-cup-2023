package io.github.womensworldcup2023.service.impl

import io.github.womensworldcup2023.domain.model.Team
import io.github.womensworldcup2023.domain.repository.TeamRepository
import io.github.womensworldcup2023.service.TeamService
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.IllegalArgumentException

@Service
class TeamServiceImpl(private val teamRepository: TeamRepository): TeamService {

    @Transactional(readOnly = true)
    override fun findAll(): List<Team> {
        return teamRepository.findAll(Sort.by(Sort.Direction.DESC, "score"))
    }

    @Transactional(readOnly = true)
    override fun findById(id: String): Team {
        return teamRepository.findById(id).orElseThrow(){NoSuchElementException("Team not found with abbreviation: $id")}
    }

    @Transactional
    override fun create(model: Team): Team {
        if (teamRepository.existsById(model.id)) throw IllegalArgumentException("Team with abbreviation: ${model.id} already exists")
        return teamRepository.save(model)
    }

    @Transactional
    override fun update(id: String, model: Team): Team {
        if (model.id != id) throw IllegalArgumentException("The abbreviations to be updated must be the same")
        val dbTeam = this.findById(id)

        dbTeam.name = model.name
        dbTeam.score = model.score

        return teamRepository.save(dbTeam)
    }

    @Transactional
    override fun delete(id: String) {
        val dbTeam = this.findById(id)
        teamRepository.delete(dbTeam)
    }


}