package org.parsisys.tehranuniversity.library.view.beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.RichPoll;

import org.apache.myfaces.trinidad.event.PollEvent;
import org.apache.myfaces.trinidad.model.UploadedFile;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class progressBar  extends org.apache.myfaces.trinidad.model.BoundedRangeModel{
  private long availableBytes;
  private long maximumBytes;
  private UploadedFile file;
  private long sizeOfFile;
  private RichPoll pollid;
  private long percentageUploaded;
    public progressBar() {
        super();
    }
  public void uploadedFileChanged(ValueChangeEvent valueChangeEvent) {
      file = (UploadedFile)valueChangeEvent.getNewValue();
      if (file != null) {
          setSizeOfFile(file.getLength());
      }
  }

  public void doUpload(ActionEvent actionEvent) {
      if (file != null) {
          setSizeOfFile(file.getLength());
          Map<String, Object> atts = getPollid().getAttributes();
          InputStream is;
          OutputStream os;

          File destinationFile = new File(file.getFilename());
          try {
              is = file.getInputStream();
              os = new FileOutputStream(destinationFile);
              int data;
              setMaximumBytes(getSizeOfFile());
              while ((data = is.read()) != -1) {
                  os.write(data);
                  setAvailableBytes(is.available());
              }
              this.stopPoll();
              FacesContext fctx = FacesContext.getCurrentInstance();
              FacesMessage message =
                  new FacesMessage("Succesfully uploaded file: " + " " +
                                   file.getFilename() + ", containing " +
                                   getSizeOfFile() + " bytes.");
              message.setSeverity(FacesMessage.SEVERITY_INFO);
              fctx.addMessage(null, message);

              is.close();
              os.close();
          } catch (IOException e) {
              e.printStackTrace();

              FacesMessage message = new FacesMessage(e.getMessage());
              message.setSeverity(FacesMessage.SEVERITY_ERROR);
              FacesContext.getCurrentInstance().addMessage(null, message);
          }
      }
  }

  public long getMaximum() {
      long result;
      long maxByte = getMaximumBytes();
      if (maxByte == 0)
          result = -1;
      else {
          result = maxByte;
      }
      return result;
  }

  public long getValue() {
      long result;
      long availableByte = getMaximumBytes() - getAvailableBytes();
      if (availableByte == 0 || availableByte == getMaximumBytes())
          result = -1;
      else {
          result = availableByte;
      }
      return result;
  }

  public void setAvailableBytes(long availableBytes) {
      this.availableBytes = availableBytes;
      setPercentageUploaded(getValue() * 100 / getMaximum());
  }

  public long getAvailableBytes() {
      return availableBytes;
  }

  public void setMaximumBytes(long maximumBytes) {
      this.maximumBytes = maximumBytes;
  }

  public long getMaximumBytes() {
      return maximumBytes;
  }

  public void setFile(UploadedFile file) {
      this.file = file;
  }

  public UploadedFile getFile() {
      return file;
  }

  public void setPollid(RichPoll pollid) {
      this.pollid = pollid;
  }

  public RichPoll getPollid() {
      return pollid;
  }

  public void setSizeOfFile(long sizeOfFile) {
      this.sizeOfFile = sizeOfFile;
  }

  public long getSizeOfFile() {
      return sizeOfFile;
  }


  public void setPercentageUploaded(long percentageUploaded) {
      this.percentageUploaded = percentageUploaded;
  }

  public long getPercentageUploaded()  {
      return percentageUploaded;
  }

  public void stopPoll() {
      FacesContext fctx = FacesContext.getCurrentInstance();
      ExtendedRenderKitService service =
          Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
      service.addScript(fctx,
                        "AdfPage.PAGE.findComponent('" + getPollid().getClientId(fctx) +
                        "').setInterval(-1);");
  }

  public void pollListenerFunc(PollEvent pollEvent) {
      System.out.println("poll event...");
  }
}
