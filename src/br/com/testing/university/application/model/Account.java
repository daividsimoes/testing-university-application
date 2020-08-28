package br.com.testing.university.application.model;

/**
 * The class represents an user account entity
 * 
 * @author Daivid
 * 
 */
public class Account {

	private String username;
	private String password;

	public Account(String username, String password) {

		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Account account = (Account) obj;
		return (username.equals(account.username) && password.equals(account.password));
	}

	@Override
	public int hashCode() {

		return username.concat(password).hashCode();
	}
}