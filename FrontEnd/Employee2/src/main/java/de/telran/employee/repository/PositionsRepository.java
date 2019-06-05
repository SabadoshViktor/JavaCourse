package de.telran.employee.repository;

import de.telran.employee.dto.PositionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class PositionsRepository {

    Logger logger = LoggerFactory.getLogger(PositionsRepository.class);

    private int lastId = 0;

    private final Map<Integer, PositionDto> positionRepository
            = new HashMap<>();

 /*   var mapPosition = {
            "1":"Worker",
            "2":"Manager",
            "3":"Co-worker"
};
*/

    @PostConstruct
    public void init() {
        PositionDto position1= new PositionDto();
        position1.setValue(1);
        position1.setDisplay("Worker");
        createPosition(position1);
        logger.info("position1 ", position1);

        PositionDto position2= new PositionDto();
        position1.setValue(2);
        position1.setDisplay("Manager");
        createPosition(position2);
        logger.info("position2 ", position2);

        PositionDto position3= new PositionDto();
        position1.setValue(3);
        position1.setDisplay("Co-worker");
        createPosition(position3);
        logger.info("position3 ", position3);
    }

    public List<PositionDto> getPositions() {
        return new ArrayList<>(positionRepository.values());
    }

    public PositionDto createPosition(PositionDto positionDto) {
        positionDto.setValue(generateNewId());
        positionRepository.put(positionDto.getValue(), positionDto);
        return positionDto;
    }

    private int generateNewId() {
        return ++lastId;
    }
}
