package com.example.timemanager.ui.settings;

import android.util.Xml;

import com.example.timemanager.ui.projects.Project;

import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * class to write an XML for the storage of the data
 */
public class StorageXML {

    private static final String XML_PROJECT = "project", XML_PROJECTLIST = "projectlist", XML_PROJECTNAME = "projectname";
    private static final String XML_PROJECTDESCRIPTION = "projectdescription", XML_PROJECTHOURS_WEEK = "hours per week", XML_COLOR = "color";
    private static final String XML_FILE = "/TimeManagerProjects.xml";

    FileOutputStream fileOutputStream = null;


    /**
     * writes the document which contains the list of projects. The encoding of this document is UTF-8.
     */
    public void writeConfigFile(List<Project> projects, String path) throws IOException {
        try {
            File file = new File(path + XML_FILE);
            fileOutputStream = new FileOutputStream(file);

            XmlSerializer serializer = Xml.newSerializer();
            serializer.setOutput(fileOutputStream, "UTF-8");
            serializer.startDocument("UTF-8", true);
            serializer.startTag("", XML_PROJECTLIST);

            for(Project project : projects) {
                serializer.startTag("", XML_PROJECT);
                serializeProject(serializer, project);
                serializer.endTag("", XML_PROJECT);
            }
            serializer.endTag("", XML_PROJECTLIST);
            serializer.endDocument();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {
            if(fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }

    /**
     * structures the data
     */
    private void serializeProject(XmlSerializer serializer, Project project) throws IOException {
        serializer.startTag("", XML_PROJECTNAME);
        serializer.text(project.getProjName());
        serializer.endTag("", XML_PROJECTNAME);
        serializer.startTag("", XML_PROJECTDESCRIPTION);
        serializer.text(project.getDescription());
        serializer.endTag("", XML_PROJECTDESCRIPTION);
        serializer.startTag("", XML_PROJECTHOURS_WEEK);
        serializer.text(String.valueOf(project.getPlannedHours()));
        serializer.endTag("", XML_PROJECTHOURS_WEEK);
        serializer.startTag("", XML_COLOR);
        serializer.text(project.getColor());
        serializer.endTag("", XML_COLOR);
    }

}
