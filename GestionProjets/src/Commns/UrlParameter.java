package Commns;

import java.util.Map;

import javax.faces.context.FacesContext;

public class UrlParameter {

	public String getParam(String name) {

		FacesContext fc = FacesContext.getCurrentInstance();

		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();

		return params.get(name);
	}

}
