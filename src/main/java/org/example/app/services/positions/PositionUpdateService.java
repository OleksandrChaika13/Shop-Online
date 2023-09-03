package org.example.app.services.positions;

import org.example.app.entities.Position;
import org.example.app.repositories.positions.PositionUpdateRepository;
import org.example.app.utils.Constants;

public class PositionUpdateService {

    private final PositionUpdateRepository repository;

    public PositionUpdateService(PositionUpdateRepository repository) {
        this.repository = repository;
    }

    public String updatePosition(int positionId, String updatedName) {
        if (!repository.positionExists(positionId)) {
            return Constants.UPDATE_WRONGID_MSG;
        }

        Position updatedPosition = new Position();
        updatedPosition.setId(positionId);
        updatedPosition.setName(updatedName);

        int affectedRows = repository.updatePosition(updatedPosition);

        if (affectedRows > 0) {
            return Constants.UPDATE_SUCCESS_MSG;
        } else {
            return Constants.UPDATE_FAILURE_MSG;
        }
    }

    public boolean positionExists(int positionId) {
        return repository.positionExists(positionId);
    }
}