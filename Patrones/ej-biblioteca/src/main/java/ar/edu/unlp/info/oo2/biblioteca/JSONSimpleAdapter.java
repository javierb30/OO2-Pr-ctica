package ar.edu.unlp.info.oo2.biblioteca;

import java.util.List;

import org.json.simple.*;

public class JSONSimpleAdapter extends VoorheesExporter{
	
	public String exportar(List<Socio> socios){
		JSONArray arregloJSON = new JSONArray();
		socios.stream()
			.forEach(socio -> arregloJSON.add(this.crearSocio(socio)));
		return arregloJSON.toJSONString();
	}
	
	private JSONObject crearSocio(Socio socio){
		JSONObject objetoJSON = new JSONObject();
		objetoJSON.put("nombre", socio.getNombre());
		objetoJSON.put("email", socio.getEmail());
		objetoJSON.put("legajo", socio.getLegajo());
		return objetoJSON;
	}
	
}
