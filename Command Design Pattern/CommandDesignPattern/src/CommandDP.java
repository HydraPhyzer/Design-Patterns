import java.io.File;

interface Command {
    void Execute();
}

interface FileSystemReceiver {
    void CloseFile();

    void WriteFile();

    void OpenFile();
}

class OpenFileCommand implements Command {
    private FileSystemReceiver FSR;

    public OpenFileCommand(FileSystemReceiver FSR) {
        this.FSR = FSR;
    }

    @Override
    public void Execute() {
        FSR.OpenFile();
    }
}

class WriteFileCommand implements Command {
    private FileSystemReceiver FSR;

    public WriteFileCommand(FileSystemReceiver FSR) {
        this.FSR = FSR;
    }

    @Override
    public void Execute() {
        FSR.WriteFile();
    }
}

class CloseFileCommand implements Command {
    private FileSystemReceiver FSR;

    public CloseFileCommand(FileSystemReceiver FSR) {
        this.FSR = FSR;
    }

    @Override
    public void Execute() {
        FSR.CloseFile();
    }
}

class WindowsFileSystemReceiver implements FileSystemReceiver {

    @Override
    public void CloseFile() {
        System.out.println("Closing Windows File");
    }

    @Override
    public void WriteFile() {
        System.out.println("Writing Windows File");
    }

    @Override
    public void OpenFile() {
        System.out.println("Opening Windows File");
    }
}

class LinuxFileSystemReceiver implements FileSystemReceiver {

    @Override
    public void CloseFile() {
        System.out.println("Closing Linux File");
    }

    @Override
    public void WriteFile() {
        System.out.println("Writing Linux File");
    }

    @Override
    public void OpenFile() {
        System.out.println("Opening Linux File");
    }
}

class FileInvoker {
    public Command C1;

    public FileInvoker(Command C) {
        C1 = C;
    }

    public void Execute() {
        C1.Execute();
    }
}

public class CommandDP {
    public static void main(String args[]) {
        FileSystemReceiver FSR = new WindowsFileSystemReceiver();
        FileSystemReceiver LSR = new LinuxFileSystemReceiver();

        OpenFileCommand OFC = new OpenFileCommand(FSR);
        CloseFileCommand CFC = new CloseFileCommand(FSR);
        WriteFileCommand WFC = new WriteFileCommand(FSR);


        FileInvoker FI = new FileInvoker(OFC);
        FI.Execute();
        FI = new FileInvoker(CFC);
        FI.Execute();
        FI = new FileInvoker(WFC);
        FI.Execute();
        System.out.println("=================");

        OpenFileCommand OFCL = new OpenFileCommand(LSR);
        CloseFileCommand CFCL = new CloseFileCommand(LSR);
        WriteFileCommand WFCL = new WriteFileCommand(LSR);

        FileInvoker FIL = new FileInvoker(OFCL);
        FIL.Execute();
        FIL = new FileInvoker(CFCL);
        FIL.Execute();
        FIL = new FileInvoker(WFCL);
        FIL.Execute();

    }
}
