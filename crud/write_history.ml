(* write_history.ml *)

(* write_to_csv.ml *)

let write_to_csv player_name draw =
  (* Logic to write to the CSV file using player_name and draw *)
  (* This is where you would write the actual implementation *)

  print_endline "Writing to CSV...";
  (* Dummy implementation, replace the line above with the actual logic *)
  print_endline (player_name ^ ": " ^ (Array.to_list draw |> List.map (fun (a, b) -> "(" ^ string_of_int a ^ "," ^ string_of_int b ^ ")") |> String.concat "; "))

let () =
  if Array.length Sys.argv <> 3 then
    prerr_endline "Usage: write_to_csv <player_name> <draw>"
  else
    let player_name = Sys.argv.(1) in
    let draw = Sys.argv.(2) |> String.split_on_char ',' |> List.map int_of_string |> Array.of_list in
    write_to_csv player_name draw
