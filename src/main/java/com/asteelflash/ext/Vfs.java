package com.asteelflash.ext;

import org.apache.commons.vfs2.*;
import org.apache.commons.vfs2.impl.StandardFileSystemManager;
import org.apache.commons.vfs2.provider.sftp.IdentityInfo;
import org.apache.commons.vfs2.provider.sftp.SftpFileSystemConfigBuilder;

import java.io.File;
import java.util.List;

/**
 * @author happy.he
 * @version 1.0
 * @date 11/9/2021 3:06 PM
 */
public class Vfs {
    private StandardFileSystemManager standardFileSystemManager = null;

    public Vfs() throws Exception {
        standardFileSystemManager = new StandardFileSystemManager();
        standardFileSystemManager.init();
    }

    /*
     * create connection string
     * */
    public static String createConnectionString(String userName, String ftpPassword, String hostName, String remotePath) {
        if (ftpPassword == null ) {
            return "sftp://" + userName + "@" + hostName + "/" + remotePath;
        } else {
            return "sftp://" + userName + ":" + ftpPassword + "@" + hostName + "/" + remotePath;
        }
    }

    /*
     * get default operations
     * */
    public static FileSystemOptions getDefaultOptions(String keyPath, String passphrase) throws FileSystemException {
        FileSystemOptions options = new FileSystemOptions();
        SftpFileSystemConfigBuilder.getInstance().setStrictHostKeyChecking(options, "no");
        SftpFileSystemConfigBuilder.getInstance().setUserDirIsRoot(options, true);
        SftpFileSystemConfigBuilder.getInstance().setTimeout(options, 10000);
        if (keyPath != null) {
            IdentityInfo identityInfo = null;
            if (passphrase != null) {
                identityInfo = new IdentityInfo(new File(keyPath), passphrase.getBytes());
            } else {
                identityInfo = new IdentityInfo(new File(keyPath));
            }
            SftpFileSystemConfigBuilder.getInstance().setIdentityInfo(options, identityInfo);
        }
        return options;
    }

    /*
     * upload
     * */
    public Response upload(String connectionString, List<File> files, FileSystemOptions fileSystemOptions, FileSelector fileSelector) {
        Response response = new Response();
        try {
            for (int i = 0; i < files.size(); i++) {
                File f = files.get(i);
                FileObject localFileObject = standardFileSystemManager.resolveFile(f.getAbsolutePath());
                FileObject remotefileObject = standardFileSystemManager.resolveFile(connectionString, fileSystemOptions);
                
                //remoteFile.copyFrom(localFile, Selectors.SELECT_SELF);
                
                remotefileObject.copyFrom(localFileObject, fileSelector);
            }
        } catch (Exception ex) {
            standardFileSystemManager.close();
            response.setResult(false);
            response.setMessage("Upload:" + ex.getMessage());
            return response;
        }
        standardFileSystemManager.close();
        return response;
    }

    /*
     * download
     * */
    public Response download(String localDirectory, String fileName, String connectionString, FileSystemOptions fileSystemOptions, FileSelector fileSelector) {
        Response response = new Response();
        try {
            FileObject localFileObject = standardFileSystemManager.resolveFile(localDirectory + fileName);
            FileObject fileObject = standardFileSystemManager.resolveFile(connectionString, fileSystemOptions);
            localFileObject.copyFrom(fileObject, fileSelector);
        } catch (Exception ex) {
            standardFileSystemManager.close();
            response.setResult(false);
            response.setMessage("Upload:" + ex.getMessage());
            return response;
        }
        standardFileSystemManager.close();
        return response;
    }

    /*
     * gets standard file system manager
     * */
    public StandardFileSystemManager getStandardFileSystemManager() {
        return standardFileSystemManager;
    }

}
