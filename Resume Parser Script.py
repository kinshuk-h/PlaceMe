from pyresparser import ResumeParser

data = ResumeParser('H:/PlaceMe/sample_resume.pdf').get_extracted_data()
print(data)
