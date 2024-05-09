package it.corso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.RuoloDao;
import it.corso.dto.AddRuoloDTO;
import it.corso.dto.CategoriaShowDTO;
import it.corso.dto.RuoloShowDTO;
import it.corso.model.Ruolo;
import it.corso.model.Categoria;
import it.corso.model.NomeRuolo;

@Service
public class RuoloServiceImpl implements RuoloService {
	private ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private RuoloDao ruoloDao;
	
	public RuoloServiceImpl() {
		modelMapper = new ModelMapper();
		// Mappatura personalizzata per fixare un bug sul get del nome, specificando che il nome dev'essere prelevato dal metodo getTipologia
		modelMapper.createTypeMap(Ruolo.class, RuoloShowDTO.class)
			.addMappings(mapping -> mapping.map(src -> src.getTipologia(), RuoloShowDTO::setNome));
    }

	@Override
	public RuoloShowDTO getRuoloById(int id) {
		Optional<Ruolo> ruoloOption = ruoloDao.findById(id);
		
		if (ruoloOption.isPresent()) {
			Ruolo ruolo = ruoloOption.get();
			
			return modelMapper.map(ruolo, RuoloShowDTO.class);
		}
		
		return null;
	}

	@Override
	public List<RuoloShowDTO> getRuoli() {
		List<Ruolo> listaRuoli = (List<Ruolo>) ruoloDao.findAll();
		List<RuoloShowDTO> ruoloShowDTO = new ArrayList<>();
				
		listaRuoli.forEach(c -> {
			RuoloShowDTO ruoloDTO = modelMapper.map(c, RuoloShowDTO.class);
			ruoloShowDTO.add(ruoloDTO);
		});
		
		return ruoloShowDTO;
    }

	@Override
	public void creaRuolo(AddRuoloDTO ruolo) {
		Ruolo ruoloObj = new Ruolo();
		ruoloObj.setTipologia(ruolo.getNome());
		
		ruoloDao.save(ruoloObj);
	}
	
	public void deleteRuoloById(int id) {
		Optional<Ruolo> ruoloOption = ruoloDao.findById(id);
		
		if (ruoloOption.isPresent()) {
			ruoloDao.delete(ruoloOption.get());
		}
	}
	
	@Override
	public void updateRuolo(RuoloShowDTO ruolo) {
		try {
		    Optional<Ruolo> ruoloDbOptional = ruoloDao.findById(ruolo.getId());

		    if (ruoloDbOptional.isPresent()) {
		        Ruolo ruoloDb = ruoloDbOptional.get();
		        ruoloDb.setTipologia(NomeRuolo.valueOf(ruolo.getNome()));
		        ruoloDao.save(ruoloDb);
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
}
