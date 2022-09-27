
package ar.com.educacionit.domain;

public enum CuponViewsEnum {

	LIST("/cupon/list"),
	EDIT("/cupon/edit"),
	NEW("/cupon/new")
	;
	
	private String view;
	
	private CuponViewsEnum(String view) {
		this.view = view;			
	}

	public String getView() {
		return view;
	}
	
}