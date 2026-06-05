public class Lesson20Interface {
    public static void run() {
        IStorageService storageService = new S3StorageService("AWS East-Europe", "bucket.east-eu.1235");
        var base64EncodedAsset = "BASD0123213==";
        storageService.Save(base64EncodedAsset);
        System.out.println(storageService.Load("lighthouse-124"));

        storageService = new FileStorageService("sftp://assets.store/west");
        storageService.Save(base64EncodedAsset);
        System.out.println(storageService.Load("lighthouse-124"));
    }
}

interface IStorageService {
    void Save(String base64asset);

    String Load(String assetId);
}

class S3StorageService implements IStorageService {
    String name;
    String address;

    S3StorageService(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public void Save(String base64asset) {
        System.out.println("Saving to AWS S3");
    }

    @Override
    public String Load(String assetId) {
        System.out.println("Loading `" + assetId + "`  from AWS S3");
        return "BASD0123213==";
    }
}

class FileStorageService implements IStorageService {
    String path;

    FileStorageService(String path) {
        this.path = path;
    }

    @Override
    public void Save(String base64asset) {
        System.out.println("Saving to File system");
    }

    @Override
    public String Load(String assetId) {
        System.out.println("Loading `" + assetId + "` from File system");
        return "BASD0123213==";
    }
}
