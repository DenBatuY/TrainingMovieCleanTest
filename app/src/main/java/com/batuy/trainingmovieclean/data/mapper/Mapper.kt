package com.batuy.trainingmovieclean.data.mapper

import com.batuy.trainingmovieclean.data.database.MovieDb
import com.batuy.trainingmovieclean.data.network.model.MovieDto
import com.batuy.trainingmovieclean.domain.Movie
import javax.inject.Inject

class Mapper @Inject constructor() {

    fun mapMovieDtoToEntity(dto: MovieDto): Movie {
        return Movie(
            id = dto.id,
            name = dto.name,
            description = dto.description,
            year = dto.year,
            posterUrl = dto.poster?.url,
            ratingKp = dto.rating.kp
        )

    }

    fun mapEntityToDbModel(entity: Movie): MovieDb {
        return MovieDb(
            id = entity.id,
            name = entity.name,
            description = entity.description,
            year = entity.year,
            posterUrl = entity?.posterUrl,
            ratingKp = entity.ratingKp
        )
    }

    fun mapDbModelToEntity(db: MovieDb): Movie {
        return Movie(
            id = db.id,
            name = db.name,
            description = db.description,
            year = db.year,
            posterUrl = db?.posterUrl,
            ratingKp = db.ratingKp
        )
    }
}