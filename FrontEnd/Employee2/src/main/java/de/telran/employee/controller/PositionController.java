package de.telran.employee.controller;



import de.telran.employee.dto.PositionDto;
import de.telran.employee.repository.PositionsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/position")
public class PositionController {

    private final Logger logger = LoggerFactory.getLogger(PositionController.class);

    private final PositionsRepository positionsRepository;


    public PositionController(PositionsRepository positionsRepository) {
        this.positionsRepository = positionsRepository;
    }

    @PostMapping("")
    public Integer createPosition(@RequestBody PositionDto positionDto) {
        logger.info(positionDto.toString());
        return 1;
    }

    @GetMapping("")
    public List<PositionDto> getPosition(){
        return positionsRepository.getPositions();

    }

}
