package com.example.lordoftheringsapi_retrofit

import com.google.gson.annotations.SerializedName

data class Posts(
    @SerializedName("docs")
    val docs: List<Doc>

)

data class Doc(
    @SerializedName("name")
    val name: String
)