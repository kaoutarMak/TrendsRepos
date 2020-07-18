package com.trend.model;

import java.util.ArrayList;
import java.util.List;


public class Response {
	private List<Language> languages = new ArrayList<Language>();

	public Response() {
	}

	public Response(List<Language> languages) {
		this.languages = languages;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public void addLanguage(String lg, String repo) {
		Language lang = new Language();		
		if (!this.languageAlreadyExist(lg)) {			
			lang.setName(lg);
			lang.addRepo(repo);
			this.languages.add(lang);
		} else {			
			lang = this.findLanguage(lg);
			if (lang != null) {
				int index = this.languages.indexOf(lang);
				lang.addRepo(repo);
				this.languages.set(index, lang);
			}
		}
	}

	public boolean languageAlreadyExist(String lg) {
		boolean exist = false;
		for (Language lang : this.languages) {
			if (lang.getName().equals(lg)) {
				exist = true;
				break;
			}
		}
		return exist;
	}

	public Language findLanguage(String lg) {
		Language currentLang = null;
		for (Language lang : this.languages) {
			if (lang.getName().equals(lg)) {
				currentLang = lang;
				break;
			}
		}
		return currentLang;
	}
}

