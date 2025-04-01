import os
import re

def remove_nonnull_from_file(file_path):
    try:
        # Read the file content
        with open(file_path, 'r') as file:
            lines = file.readlines()

        # Update lines by removing @javax.annotation.Nonnull but keeping the rest
        updated_lines = [
            re.sub(r'@javax\.annotation\.Nonnull\s*', '', line) if '@javax.annotation.Nonnull' in line else line
            for line in lines
        ]

        # Write the updated content back to the file
        with open(file_path, 'w') as file:
            file.writelines(updated_lines)

        print(f"Processed: {file_path}")
    except Exception as e:
        print(f"An error occurred while processing {file_path}: {e}")

def process_java_files_in_directory(directory_path):
    for root, _, files in os.walk(directory_path):
        for file in files:
            if file.endswith('.java'):
                file_path = os.path.join(root, file)
                remove_nonnull_from_file(file_path)

# Specify the directory to process
directory_path = '/Users/mmerali/test-java-sdk/src/main/java/com/hopper/cloud/airlines/model'

# Call the function
process_java_files_in_directory(directory_path)