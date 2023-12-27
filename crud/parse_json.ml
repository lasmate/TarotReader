open Yojson.Basic
open Yojson.Basic.Util

(*
  [extract_names json] is a recursive function that extracts the names from a JSON object.

  - [json] is the JSON object to extract names from.

  The function matches the JSON object with the following patterns:
  - If the JSON object is a list of interpretations, it extracts the "name" field from each interpretation and concatenates them with a comma separator.
  - If the JSON object is not a list, it raises an exception with the message "Invalid JSON format".

  Returns a string containing the extracted names.
*)
let rec extract_names json =
  match json with
  | `List interpretations ->
    let names = List.map (fun interpretation -> member "name" interpretation |> to_string) interpretations in
    String.concat "," names
  | _ -> failwith "Invalid JSON format"

(*
   This code reads a JSON file named "Tarot-DB.json" and extracts the names of tarot interpretations from it.
   It then prints the extracted names to the standard output.

   Exceptions:
   - Sys_error: If there is an error while reading the JSON file.
   - Yojson.Json_error: If there is an error while parsing the JSON data.
   - Failure: If there is any other error during the execution of the code.
*)
let () =
  try
    let json = from_file "../Tarot-DB.json" in
    let tarot_interpretations = member "tarot_interpretations" json in
    let result = extract_names tarot_interpretations in
    Printf.printf "%s\n" result
  with
  | Sys_error msg -> Printf.eprintf "Error: %s\n" msg
  | Yojson.Json_error msg -> Printf.eprintf "JSON Error: %s\n" msg
  | Failure msg -> Printf.eprintf "Error: %s\n" msg
