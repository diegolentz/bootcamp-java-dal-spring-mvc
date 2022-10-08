
package ar.com.educacionit.enums;

public enum SociosKeysEnum {

	SOCIOS("SOCIOS"), 
	SOCIO("SOCIO")
	;
	
	private String key;
	
	private SociosKeysEnum(String key) {
		this.key = key;			
	}

	public String getKey() {
		return key;
	}
	
}