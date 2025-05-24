package br.fatec.HelpDesk.services;

import br.fatec.HelpDesk.entities.Status;
import br.fatec.HelpDesk.enums.TipoStatus;
import br.fatec.HelpDesk.repositories.StatusRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

    @Autowired
    StatusRepository statusRepository;

    private static final Logger log =
            LoggerFactory.getLogger(StatusService.class);

    @PostConstruct
    public void initStatus() {
        for (TipoStatus tipo : TipoStatus.values()) {
            boolean exists = statusRepository.existsById(tipo);
            if (!exists) {
                Status status = new Status();
                status.setStatus(tipo);
                statusRepository.save(status);
                log.info("Status {} criado", tipo);
            }
        }
    }
}

