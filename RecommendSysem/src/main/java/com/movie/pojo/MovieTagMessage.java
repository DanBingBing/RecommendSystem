package com.movie.pojo;

public class MovieTagMessage {
    private Integer mtmId;

    private Integer movId;

    private Integer tagId;
    
    private Movie movie;
    
    private MovieTag movieTag;

    public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public MovieTag getMovieTag() {
		return movieTag;
	}

	public void setMovieTag(MovieTag movieTag) {
		this.movieTag = movieTag;
	}

    public Integer getMtmId() {
        return mtmId;
    }

    public void setMtmId(Integer mtmId) {
        this.mtmId = mtmId;
    }

    public Integer getMovId() {
        return movId;
    }

    public void setMovId(Integer movId) {
        this.movId = movId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

	@Override
	public String toString() {
		return "MovieTagMessage [mtmId=" + mtmId + ", movId=" + movId + ", tagId=" + tagId + ", movie=" + movie
				+ ", movieTag=" + movieTag + "]";
	}
    
}