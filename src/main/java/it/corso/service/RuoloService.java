package it.corso.service;

import java.util.List;

import it.corso.dto.AddRuoloDTO;
import it.corso.dto.RuoloShowDTO;
import it.corso.model.Ruolo;

public interface RuoloService {
	RuoloShowDTO getRuoloById(int id);
	List<RuoloShowDTO> getRuoli();
	void creaRuolo(AddRuoloDTO ruolo);
	void deleteRuoloById(int id);
	void updateRuolo(RuoloShowDTO ruolo);
}
