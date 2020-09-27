package com.audio_translator.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//Userid, assetType [audio, transcript, translation], assetId, content, timestamp

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "asset")
public class Asset {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="asset_id")
	private Integer asset_id;
	
	@Column(name="audio")
	private String audio;
	
	@Column(name="transcript")
	private String transcript;
	
	@Column(name="translation")
	private String translation;
	
	@Column(name="content")
	private String content;
	
	@Column(name="timetamp")
	private LocalDateTime timetamp;

	@ManyToOne(cascade= {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
    private User user;
	
	public Asset(String audio, String transcript, String tranlation, String assetId, String content, LocalDateTime timetamp) {
		this.audio = audio;
		this.transcript = transcript;
		this.translation = tranlation;
		this.content = content;
		this.timetamp = LocalDateTime.now();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Asset asset = (Asset) o;
		return 
			Objects.equals(asset_id, asset.asset_id) &&
			Objects.equals(audio, asset.audio) &&
			Objects.equals(transcript, asset.transcript) &&
			Objects.equals(translation, asset.translation) &&
			Objects.equals(content, asset.content) &&
			Objects.equals(timetamp, asset.timetamp);
	}

	@Override
	public int hashCode() {

		return Objects.hash(asset_id, audio, transcript, translation, content, timetamp);
	}

	@Override
	public String toString() {
		return "asset{" +
			"asset_id=" + asset_id +
			", audio='" + audio + '\'' +
			", transcript='" + transcript + '\'' +
			", translation='" + translation + '\'' +
			", content='" + content + '\'' +
			", timetamp='" + timetamp + '\'' +
			'}';
	}
}
