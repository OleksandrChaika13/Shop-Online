package org.example.app.controllers.positions;

import org.example.app.services.positions.PositionUpdateService;
import org.example.app.utils.AppStarter;
import org.example.app.views.positions.PositionUpdateView;

public class PositionUpdateController {

    private final PositionUpdateService service;
    private final PositionUpdateView view;

    public PositionUpdateController(PositionUpdateService service, PositionUpdateView view) {
        this.service = service;
        this.view = view;
    }

    public void updatePosition() {
        int positionId = view.getPositionId();

        if (positionId != -1) {
            if (!service.positionExists(positionId)) {
                view.getOutput("This ID does not exist. Update failed.");
            } else {
                String updatedName = view.getUpdatedData();
                String result = service.updatePosition(positionId, updatedName);
                view.getOutput(result);
            }
        }

        AppStarter.startApp();
    }
}
