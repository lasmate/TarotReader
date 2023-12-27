open Yojson.Basic
open Yojson.Basic.Util

let rec extract_names json =
  match json with
  | `List interpretations ->
    let names = List.map (fun interpretation -> member "name" interpretation |> to_string) interpretations in
    String.concat "," names
  | _ -> failwith "Invalid JSON format"

let () =
  try
    let json = from_file "Tarot-DB.json" in
    let tarot_interpretations = member "tarot_interpretations" json in
    let result = extract_names tarot_interpretations in
    Printf.printf "%s\n" result
  with
  | Sys_error msg -> Printf.eprintf "Error: %s\n" msg
  | Yojson.Json_error msg -> Printf.eprintf "JSON Error: %s\n" msg
  | Failure msg -> Printf.eprintf "Error: %s\n" msg
