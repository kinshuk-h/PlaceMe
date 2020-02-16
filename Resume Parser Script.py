from pyresparser import ResumeParser

data = ResumeParser('H:/PlaceMe/sample_resume_3.pdf').get_extracted_data()
print(data)
