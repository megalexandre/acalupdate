package br.org.acal.domain.usecase.database;

import br.org.acal.resouces.backup.DatabaseBackup;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class BackupUseCase {

    private final DatabaseBackup backupService;

    public BackupUseCase(DatabaseBackup backupService) {
        this.backupService = backupService;
    }

    public void execute() throws IOException, InterruptedException {
        backupService.backupDatabase();
    }

}
