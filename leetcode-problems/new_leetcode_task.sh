#!/usr/bin/env bash
set -euo pipefail

# Usage:
#   ./new_lc.sh "33. Search in Rotated Sorted Array"
#   ./new_lc.sh "268 Missing Number"
# Options:
#   -f   overwrite existing files (default: do not overwrite)

FORCE=0
if [[ "${1:-}" == "-f" ]]; then
  FORCE=1
  shift
fi

INPUT="${1:-}"
if [[ -z "$INPUT" ]]; then
  echo "Usage: $0 [-f] \"33. Search in Rotated Sorted Array\""
  exit 1
fi

# Extract leading number (problem id)
# Accepts: "33. Title", "33 Title", "33 - Title"
if [[ "$INPUT" =~ ^[[:space:]]*([0-9]+)[[:space:]]*([.:-])?[[:space:]]*(.*)$ ]]; then
  ID="${BASH_REMATCH[1]}"
  TITLE_RAW="${BASH_REMATCH[3]}"
else
  echo "Could not parse input. Expected something like: \"33. Search in Rotated Sorted Array\""
  exit 1
fi

if [[ -z "$TITLE_RAW" ]]; then
  echo "Could not parse title from input: $INPUT"
  exit 1
fi

# Pad id to 4 digits
printf -v ID_PAD "%04d" "$ID"

# Slugify title -> lower snake_case for package/folder
# - lowercase
# - replace non-alnum with underscores
# - collapse multiple underscores
# - trim leading/trailing underscores
TITLE_LOWER="$(printf '%s' "$TITLE_RAW" | tr '[:upper:]' '[:lower:]')"
SLUG="$(printf '%s' "$TITLE_LOWER" \
  | sed -E 's/[^a-z0-9]+/_/g; s/_+/_/g; s/^_+//; s/_+$//')"

if [[ -z "$SLUG" ]]; then
  echo "Slug is empty after normalization. Title was: $TITLE_RAW"
  exit 1
fi

# Adjust these to your repo conventions if needed
BASE_PKG="io.github.owrmille.leetcode"
PROB_PKG="p${ID_PAD}_${SLUG}"
PACKAGE="${BASE_PKG}.${PROB_PKG}"

MAIN_DIR="src/main/java/$(echo "$BASE_PKG" | tr '.' '/')/${PROB_PKG}"
TEST_DIR="src/test/java/$(echo "$BASE_PKG" | tr '.' '/')/${PROB_PKG}"
RES_DIR="src/test/resources/leetcode/${PROB_PKG}"

SOLUTION_FILE="${MAIN_DIR}/Solution.java"
TEST_FILE="${TEST_DIR}/SolutionTest.java"
CASES_FILE="${RES_DIR}/cases.json"
NOTES_FILE="${MAIN_DIR}/notes.md"

mkdir -p "$MAIN_DIR" "$TEST_DIR" "$RES_DIR"

write_file() {
  local path="$1"
  local content="$2"

  if [[ -f "$path" && "$FORCE" -ne 1 ]]; then
    echo "Skip (exists): $path"
    return
  fi

  printf '%s\n' "$content" > "$path"
  echo "Created: $path"
}

write_file "$SOLUTION_FILE" "package ${PACKAGE};

//
// LeetCode ${ID}: ${TITLE_RAW}
// Difficulty: ?
// Topics: ?
// Approach: ?
// Time: ?  Space: ?
//
"

write_file "$TEST_FILE" "package ${PACKAGE};

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void sanity() {
        // Replace with real tests for: ${TITLE_RAW}
        // Example:
        // Solution s = new Solution();
        // assertEquals(expected, s.method(args));
        assertTrue(true);
    }
}
"

write_file "$CASES_FILE" "{
  \"id\": ${ID},
  \"title\": \"${TITLE_RAW}\",
  \"cases\": [
    {
      \"input\": {},
      \"output\": null
    }
  ]
}
"

write_file "$NOTES_FILE" "# LeetCode ${ID}: ${TITLE_RAW}

## Idea
- 

## Edge cases
- 

## Complexity
- Time: 
- Space: 
"

echo
echo "Package: $PACKAGE"
echo "Main:    $SOLUTION_FILE"
echo "Test:    $TEST_FILE"
echo "Cases:   $CASES_FILE"
echo "Notes:   $NOTES_FILE"
echo
echo "Next:"
echo "  mvn test"