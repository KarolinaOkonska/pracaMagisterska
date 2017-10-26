package converters;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import beans.LoginBean;
import dto.SamochodDTO;

@FacesConverter(forClass=SamochodDTO.class,value="samochodDTOConverter")
public class SamochodDTOConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (arg2 == null || arg2.isEmpty()) {
	        return null;
	    }
		
		ValueExpression vex =
				arg0.getApplication().getExpressionFactory()
                        .createValueExpression(arg0.getELContext(),
                                "#{loginBean}", LoginBean.class);

		LoginBean service = (LoginBean) vex.getValue(arg0.getELContext());
//		LoginBean service = (LoginBean) arg0.getELContext().getExternalContext().getApplicationMap().get("#{loginBean}");
		SamochodDTO pobierzSamochodPoId = service.pobierzSamochodPoId(new Long(arg2));
		service.setSamochodKontekstowy(pobierzSamochodPoId);
	    return pobierzSamochodPoId;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 == null) {
	        return "0";
	    }

	    if (arg2 instanceof SamochodDTO) {
	        return String.valueOf(((SamochodDTO) arg2).getId());
	    } 
		return arg2 + "";
	}

	
}
