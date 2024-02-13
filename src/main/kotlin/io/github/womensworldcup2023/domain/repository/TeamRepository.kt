package io.github.womensworldcup2023.domain.repository

import io.github.womensworldcup2023.domain.model.Team
import org.springframework.data.jpa.repository.JpaRepository

interface TeamRepository: JpaRepository<Team, String> {
}