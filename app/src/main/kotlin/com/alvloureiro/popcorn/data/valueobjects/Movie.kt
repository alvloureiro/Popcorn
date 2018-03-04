package com.alvloureiro.popcorn.data.valueobjects

import com.google.gson.annotations.Expose


data class Movie(
        @Expose
        var id: Int? = null,

        @Expose
        var title: String? = null,

        @Expose
        var original_title: String? = null,

        @Expose
        var genre_ids: List<Int>? = null,

        @Expose
        var poster_path: String? = null,

        @Expose
        var backdrop_path: String? = null,

        @Expose
        var overview: String? = null,

        @Expose
        var release_date: String? = null
): VO
