package com.werden.mycv.models

import com.google.gson.annotations.SerializedName

data class Resume (
    @SerializedName("About Me") var aboutMe: ArrayList<String>,
    @SerializedName("Soft Skills") var softSkills: SoftSkills,
    @SerializedName("Skills") var skills: Skills,
    @SerializedName("Information") var information: Information,
    @SerializedName("Education") var education: ArrayList<Education>,
    @SerializedName("Work Experience") var workExperience: ArrayList<WorkExperience>,
    @SerializedName("Freelance Experience") var freeLanceExperience: ArrayList<FreeLanceExperience>
)

data class SoftSkills (
    @SerializedName("Teamwork") var teamWork: String,
    @SerializedName("Continuous Learning") var continuousLearning: String,
    @SerializedName("Open Minded") var openMinded: String
)

data class  Skills(
    @SerializedName("Servers Configuration") var serverConfiguration: ArrayList<String>,
    @SerializedName("Languages Programing") var languagesPrograming: ArrayList<String>,
    @SerializedName("Databases") var dataBases: ArrayList<String>
)

data class Information (
    @SerializedName("Personal") var personal: Personal,
    @SerializedName("Contact") var contact: Contact
)

data class Personal (
    @SerializedName("Name") var name: String,
    @SerializedName("Birthday") var birthday: String,
    @SerializedName("Nationatily") var nationality: String
)

data class Contact (
    @SerializedName("Email") var email: String,
    @SerializedName("Mobile") var mobile: String,
    @SerializedName("LinkedIn") var linkedIn: String
)

class Education(
    @SerializedName("Name") var name: String,
    @SerializedName("Grade") var grade: String,
    @SerializedName("Career") var career: String,
    @SerializedName("LinkedIn") var period: String
)

data class WorkExperience (
    @SerializedName("Company") var company: String,
    @SerializedName("Project") var project: String,
    @SerializedName("Period") var period: String,
    @SerializedName("Description") var description: String,
    @SerializedName("Activities") var activities: ArrayList<String>
)

data class FreeLanceExperience (
    @SerializedName("Project") var project: String,
    @SerializedName("Period") var period: String,
    @SerializedName("Description") var description: String,
    @SerializedName("Activities") var activities: ArrayList<String>
)