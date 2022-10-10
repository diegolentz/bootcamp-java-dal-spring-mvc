

package ar.com.educacionit.enums;

	public enum SocioViewsEnum {

		LIST("socio/list"),
		EDIT("socio/edit"),
		NEW("socio/new"),
		LIST_REDIRECT("redirect:/socio/list"),
		;
		
		private String view;
		
		private SocioViewsEnum(String view) {
			this.view = view;			
		}

		public String getView() {
			return view;
		}
		
}